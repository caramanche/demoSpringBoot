--------------------------------------------------------
-- Archivo creado  - domingo-agosto-27-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PERSONA
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."PERSONA" 
   (	"ID" NUMBER(19,0), 
	"DIRECCION" VARCHAR2(30 CHAR), 
	"EDAD" NUMBER(10,0), 
	"GENERO" VARCHAR2(30 CHAR), 
	"IDENTIFICACION" VARCHAR2(20 CHAR), 
	"NOMBRE" VARCHAR2(30 CHAR), 
	"TELEFONO" VARCHAR2(20 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C008377
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008377" ON "SYSTEM"."PERSONA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table PERSONA
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."PERSONA" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PERSONA" MODIFY ("DIRECCION" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PERSONA" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PERSONA" MODIFY ("TELEFONO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PERSONA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;