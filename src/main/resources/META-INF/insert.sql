insert into DBF_FILESMETADATA(ID, CDTS, FILENAME, LOCATION, TYPEID, LMTS, STATUS) values(3, '2017-03-10', 'V_DAT', 'E:/PROJEKTE/NGJ/FAK_022017/V_DAT.dbf', 1000, '2017-03-19', 0);
insert into DBF_FILESMETADATA(ID, CDTS, FILENAME, LOCATION, TYPEID, LMTS, STATUS) values(4, '2017-03-10', 'FAKTUR', 'E:/PROJEKTE/NGJ/FAK_022017/FAKTUR.dbf', 2000, '2017-03-19', 0);


insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(1, 1000, 'Double', 'NUMMER', true, 'kundennummer', 'Long', 'Stammdaten', 55);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(2, 1000, 'Long', 'REFERENZ', false, 'debitornummer', 'String', 'Stammdaten', 95);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(3, 1000, 'String', 'NAME', false, 'kundenname', 'String', 'Stammdaten', 13);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(4, 1000, 'String', 'NAME2', false, 'name2', 'String', 'Stammdaten', 49);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(5, 1000, 'String', 'STRASSE', false, 'strasse', 'String', 'Stammdaten', 54);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(6, 1000, 'Double', 'PLZ', false, 'plz', 'Long', 'Stammdaten', 1);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(7, 1000, 'String', 'ORT', false, 'ort', 'String', 'Stammdaten', 42);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(8, 1000, 'String', 'LAND', false, 'land', 'String', 'Stammdaten', 63);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(9, 1000, 'Double', 'VOL_FAKTOR', false, 'vol_faktor.faktor', 'Double', 'Stammdaten', 48);
insert into dbf_item(id, dbfTypeId, fieldDatatype, fieldName, isPK, targetColumn, targetDatatype, targetTable, cPosition) 
values(10, 1000, 'String', 'LAND', false, 'ustid', 'String', 'Stammdaten', 77);
