  CREATE TABLE "SYSTEM"."ZAPATO" 
   (	"CODIGO" NUMBER NOT NULL ENABLE, 
	"NOMBRE" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"DESCRIPCION" VARCHAR2(255 BYTE), 
	"GENERO" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"PRECIO_VENTA" NUMBER NOT NULL ENABLE, 
	"NUMERO" FLOAT(126) NOT NULL ENABLE, 
	"COLOR" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"TIPO" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"HAY_STOCK" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"COLUMN1" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "ZAPATO_PK" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
