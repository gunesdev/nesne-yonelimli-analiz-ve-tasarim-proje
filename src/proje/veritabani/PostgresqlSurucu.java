package proje.veritabani;

import proje.ILog;
import proje.ISogutucuBilgiSistemi;
import proje.KullaniciHesabi;

import java.sql.*;

public class PostgresqlSurucu implements ISogutucuBilgiSistemi{
	private Connection baglan() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/SogutucuBilgiSistemi",
				"postgres", "1234");
	}

	@Override
	public KullaniciHesabi kullaniciDogrula(String kullaniciAdi, String parola){
		KullaniciHesabi kullaniciHesabi = null;
		try{
			Connection conn = baglan();
			if (conn != null) {
				System.out.println("Veritabanına bağlandı!");
			}else {
				System.out.println("Bağlantı girişimi başarısız!");
			}
			String sql= "SELECT *  FROM \"kullanicilar\" WHERE \"kullaniciAdi\"=\'"+ kullaniciAdi+"\' AND parola=\'"+ parola + "\';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			conn.close();
			int id;
			while(rs.next()) {
				id  = rs.getInt("id");
				kullaniciHesabi = new KullaniciHesabi(id, kullaniciAdi);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kullaniciHesabi;
	}

	@Override
	public long logla(ILog log){
		String query =  "INSERT INTO \"log\"(\"tarih\", \"kullaniciId\", \"islem\", \"islemBasariliMi\", \"deger\", \"aciklama\") "
				+ "VALUES(?,?,?,?,?,?)";
		long id = 0;
		try{
			Connection conn = baglan();
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, log.getTarih());
			pstmt.setInt(2,log.getKullaniciId());
			pstmt.setString(3, log.getIslem());
			pstmt.setBoolean(4, log.getIslemBasariliMi());
			pstmt.setObject(5, log.getDeger());
			pstmt.setString(6, log.getAciklama());
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
