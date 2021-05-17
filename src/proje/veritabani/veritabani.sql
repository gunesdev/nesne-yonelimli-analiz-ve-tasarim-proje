CREATE DATABASE "SogutucuBilgiSistemi"
ENCODING='UTF-8'
LC_COLLATE='Turkish_Turkey.1254'
LC_CTYPE='Turkish_Turkey.1254'
OWNER postgres
TEMPLATE=template0;

CREATE TABLE "kullanicilar" (
    "id" SERIAL,
    "kullaniciAdi" CHAR(20) NOT NULL,
    "parola" VARCHAR(40) NOT NULL,
    CONSTRAINT "kullaniciIdPK" PRIMARY KEY("id"),
    CONSTRAINT "kullaniciAdiUnique" UNIQUE("kullaniciAdi")
);

CREATE TABLE "log" (
    "id" SERIAL,
    "tarih" TIMESTAMP NOT NULL,
    "kullaniciId" INTEGER NOT NULL,
	"islem" TEXT NOT NULL,
	"islemBasariliMi" BOOLEAN NOT NULL,
	"deger" NUMERIC,
	"aciklama" TEXT NOT NULL,
    CONSTRAINT "logIdPK" PRIMARY KEY("id"),
	CONSTRAINT "kullaniciIdFK" FOREIGN KEY("kullaniciId") REFERENCES "kullanicilar"("id")
);

INSERT INTO "kullanicilar" 
("kullaniciAdi", "parola")
VALUES ('admin', '1234');

INSERT INTO "kullanicilar" 
("kullaniciAdi", "parola")
VALUES ('ali', 'asd123');

INSERT INTO "kullanicilar" 
("kullaniciAdi", "parola")
VALUES ('veli', 'qwerty');

INSERT INTO "kullanicilar" 
("kullaniciAdi", "parola")
VALUES ('ayse', 'ayse123');