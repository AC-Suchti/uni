package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;

public class VormerkKarteTest {
	
	VormerkKarte _vormerkKarte;
	Kunde _kunde;
	Kunde _kunde1;
	Kunde _kunde2;
	Kunde _kunde3;
	
	public VormerkKarteTest()
	{
		_vormerkKarte = new VormerkKarte();
		_kunde = new Kunde(new Kundennummer(123465798), "Vorname", "Vorname");
		_kunde1 = new Kunde(new Kundennummer(234567891), "Vorname1", "Vorname1");
		_kunde2 = new Kunde(new Kundennummer(345678912), "Vorname2", "Vorname2");
		_kunde3 = new Kunde(new Kundennummer(465789123), "Vorname3", "Vorname3");
	}
	
	@Test
	public void hinzufuegenTest()
	{
		_vormerkKarte.add(_kunde);
		assertTrue(_vormerkKarte.istEnthalten(_kunde));
	}
	
	@Test
	public void istErsterVormerkerTest()
	{
		_vormerkKarte.add(_kunde);
		assertTrue(_vormerkKarte.istErsterVormerker(_kunde));
	}
	
	@Test
	public void darfKundeVormerkenTestJa()
	{
		assertTrue(_vormerkKarte.darfKundeVormerken(_kunde));
	}
	
	@Test
	public void darfKundeVormerkenTestVorhanden()
	{
		_vormerkKarte.add(_kunde);
		assertFalse(_vormerkKarte.darfKundeVormerken(_kunde));
	}
	
	@Test
	public void darfKundeVormerkenTestVoll()
	{
		_vormerkKarte.add(_kunde);
		_vormerkKarte.add(_kunde1);
		_vormerkKarte.add(_kunde2);
		assertFalse(_vormerkKarte.darfKundeVormerken(_kunde3));
	}
	
	@Test
	public void loescheErstenVormerker()
	{
		_vormerkKarte.add(_kunde);
		_vormerkKarte.loescheErstenVormerker();
		assertTrue(_vormerkKarte.istEnthalten(_kunde));
	}

}
