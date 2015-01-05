package de.hdm.raumverwaltung.shared;

import de.hdm.raumverwaltung.shared.bo.*;

import de.hdm.raumverwaltung.shared.report.erstelleReportVonRaumFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportVonBenutzerFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportOfBuchungenFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleListeMitAlleRaeume;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * <p>
 * Synchrone Schnittstelle f�r eine RPC-f�hige Klasse zur Erstellung von
 * Reports. Diese Schnittstelle benutzt die gleiche Realisierungsgrundlage wir
 * das Paar {@link Raumverwaltung} und {@link RaumverwaltungImpl}. 
 * Zu technischen Erl�uterung etwa bzgl. GWT RPC bzw. {@link RemoteServiceServlet}
 * siehe {@link Raumverwaltung} und {@link RaumverwaltungImpl}.
 * </p>
 * <p>
 * Ein ReportGenerator bietet die M�glichkeit, eine Menge von Berichten
 * (Reports) zu erstellen, die Menge von Daten bzgl. bestimmter Sachverhalte des
 * Systems zweckspezifisch darstellen.
 * </p>
 * <p>
 * Die Klasse bietet eine Reihe von <code>erstelle...</code>-Methoden, mit deren
 * Hilfe die Reports erstellt werden k�nnen. Jede dieser Methoden besitzt eine
 * dem Anwendungsfall entsprechende Parameterliste. Diese Parameter ben�tigt der
 * der Generator, um den Report erstellen zu k�nnen.
 * </p>
 * <p> 
 * Bei neu hinzukommenden Bedarfen an Berichten, kann diese Klasse auf einfache
 * Weise erweitert werden. Hierzu k�nnen zus�tzliche <code>erstelle...</code>
 * -Methoden implementiert werden. Die bestehenden Methoden bleiben davon
 * unbeeinflusst, so dass bestehende Programmlogik nicht ver�ndert werden muss.
 * </p>
 * 
 * @author thies @ author Galina Schmidt
 */

@RemoteServiceRelativePath("reportgenerator")
public interface ReportGenerator extends RemoteService {

	public void init() throws IllegalArgumentException;
	/** 
	 * in Unseren Use Cases m�chten wir auf der Report Generator Seite die 
	 * M�glichkeiten haben Raum,-Benutzer,- und Buchungen in einen bestimmtem 
	 * Zeitraum auszugeben, dazu verwenden wir die entsprechende Parameter 
	 * der jeweilige Objekte
	 * 
	 * @see ReportVonRaumFuerZeitraum
	 * @param raum +
	 * @param anfangsZeit +
	 * @param endZeit sind die Refenzent auf das Raum und Zeitraum Objekte
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract ReportVonRaumFuerZeitraum
		erstelleReportVonRaumFuerZeitraum
			(Raum raum, Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	/**
	 * @param benutzer,anfangsZeit und endZeit sind die Refenrzen auf das report 
	 *um zu erfahren wo ein Benutzer seine Termine hat.
	  */
	
	
	public abstract ReportVonBenutzerFuerZeitraum 
		erstelleReportVonBenutzerFuerZeitraum
			(Benutzer benutzer, Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	/**
	 * @param benutzer,anfangsZeit und endZeit sind die Refenrzen auf das report 
	 *um zu erfahren wo ein Benutzer seine Termine hat.
	  */
	
	
	public abstract ReportVonBuchungenFuerZeitraum 
		erstelleReportOfBuchungenFuerZeitraum(Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines Report-Liste mit allen bestehenden  R�umen 
	 * @return ein fertiges Reportobjekt
	 * @author Galina Schmidt
	  */
	public abstract ListeMitAlleRaeume <Raum > erstelleListeMitAlleRaeume()
			throws IllegalArgumentException;
}




