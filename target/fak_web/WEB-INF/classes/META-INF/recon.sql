-- TYP0 Differences - Missing in fak2 (MINUS)
select count(*)
from fak.tbl_cu_stammdaten s left join fak2.tbl_cu_stammdaten t 
on s.kundennummer = t.kundennummer 
and t.kundennummer is null;

-- TYP1 Differences - Missing in fak (MINUS)
select count(*)
from fak.tbl_cu_stammdaten s right join fak2.tbl_cu_stammdaten t 
on s.kundennummer = t.kundennummer 
and s.kundennummer is null;

-- TYP2 Differences - In Both (INTERSECT)
select count(*) 
from fak.tbl_cu_stammdaten s, fak2.tbl_cu_stammdaten t 
where s.kundennummer = t.kundennummer
and (
	s.zahlungskondition_id != t.zahlungskondition_id or 
	s.vol_faktor_id != t.vol_faktor_id or 
	s.sonderPL_id != t.sonderPL_id or 
	s.nachnahme_id != t.nachnahme_id or 
	s.dieselfloater_id != t.dieselfloater_id or 
	s.betreuer_id != t.betreuer_id or 
	s.berechnungsModus_id != t.berechnungsModus_id or 
	--s.anpsrechpartner_lfd_Nummer != t.anpsrechpartner_lfd_Nummer or 
	--s.anpsrechpartner_kundenNummer != t.anpsrechpartner_kundenNummer or 
	s.abweichender_Frachtzahler_id != t.abweichender_Frachtzahler_id or 
	s.ustid != t.ustid or 
	s.strasse != t.strasse or 
	s.plz != t.plz or 
	s.ort != t.ort or 
	s.land != t.land or 
	s.name2 != t.name2 or 
	s.kundenname != t.kundenname or 
	s.formularCode != t.formularCode or 
	s.debitornummer != t.debitornummer or 
	s.basisPL != t.basisPL
);

select count(*) from fak.tbl_cu_stammdaten s 
where s.kundennummer not in (
	select t.kundennummer from fak2.tbl_cu_stammdaten t where s.kundennummer = t.kundennummer
);

select count(*) from fak2.tbl_cu_stammdaten t 
where t.kundennummer not in (
	select s.kundennummer from fak.tbl_cu_stammdaten s where s.kundennummer = t.kundennummer
);


select count(*) from fak.tbl_cu_stammdaten s, fak2.tbl_cu_stammdaten t 
where s.kundennummer = t.kundennummer
and (
	s.zahlungskondition_id != t.zahlungskondition_id or 
	s.vol_faktor_id != t.vol_faktor_id or 
	s.sonderPL_id != t.sonderPL_id or 
	s.nachnahme_id != t.nachnahme_id or 
	s.dieselfloater_id != t.dieselfloater_id or 
	s.betreuer_id != t.betreuer_id or 
	s.berechnungsModus_id != t.berechnungsModus_id or 
	--s.anpsrechpartner_lfd_Nummer != t.anpsrechpartner_lfd_Nummer or 
	--s.anpsrechpartner_kundenNummer != t.anpsrechpartner_kundenNummer or 
	s.abweichender_Frachtzahler_id != t.abweichender_Frachtzahler_id or 
	s.ustid != t.ustid or 
	s.strasse != t.strasse or 
	s.plz != t.plz or 
	s.ort != t.ort or 
	s.land != t.land or 
	s.name2 != t.name2 or 
	s.kundenname != t.kundenname or 
	s.formularCode != t.formularCode or 
	s.debitornummer != t.debitornummer or 
	s.basisPL != t.basisPL
); 