--------------------------------------------------------
-- Archivo creado  - domingo-agosto-27-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MOVIMIENTOS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."MOVIMIENTOS" 
   (	"ID" NUMBER(19,0), 
	"FECHA" DATE, 
	"SALDO" NUMBER(10,0), 
	"TIPO" VARCHAR2(30 CHAR), 
	"VALOR" NUMBER(10,0), 
	"FK_MOVIM_CUENTA" NUMBER(19,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C008387
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008387" ON "SYSTEM"."MOVIMIENTOS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MOVIMIENTOS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."MOVIMIENTOS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MOVIMIENTOS" MODIFY ("FECHA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MOVIMIENTOS" MODIFY ("SALDO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MOVIMIENTOS" MODIFY ("TIPO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MOVIMIENTOS" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."MOVIMIENTOS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MOVIMIENTOS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."MOVIMIENTOS" ADD CONSTRAINT "FKMDP49ESSUPS61BL990JRYUS19" FOREIGN KEY ("FK_MOVIM_CUENTA")
	  REFERENCES "SYSTEM"."CUENTA" ("ID") ENABLE;
