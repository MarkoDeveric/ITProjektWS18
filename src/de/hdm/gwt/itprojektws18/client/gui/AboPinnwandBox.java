package de.hdm.gwt.itprojektws18.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

import de.hdm.gwt.itprojektws18.client.ClientsideSettings;
import de.hdm.gwt.itprojektws18.shared.PinnwandVerwaltungAsync;
import de.hdm.gwt.itprojektws18.shared.bo.Abonnement;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;
import de.hdm.gwt.itprojektws18.shared.bo.Pinnwand;

public class AboPinnwandBox extends FlowPanel{

	
	/**
	 * Erzeugen eines PinnwandVerwaltung-Objekts um eine Applikationsverwaltung zu initialisieren.
	 */
	PinnwandVerwaltungAsync pinnwandVerwaltung = ClientsideSettings.getPinnwandVerwaltung();
	ClientsideSettings clientSettings = new ClientsideSettings();
	
	/**
	 * Instanziierung der GUI Elemente
	 */
	private Widget nutzerNameWidget = new Widget();
	
	private Widget nickNameWidget = new Widget();
	
	
	/**
	 * Deklarierung der BO, die verwendet werden
	 */
	private Nutzer nutzer = null;
	private Abonnement abo = null;
	private Pinnwand pinnwand = null;
	
	public AboPinnwandBox() {
		
	}
	
	public AboPinnwandBox(int anzahlAbos) {
		//Anzahl der Abos aus Datenbank auslesen!
	}
	
	
	public void onLoad() {
		
		//nutzerNameWidget.equals()
		
		nutzerNameWidget.addStyleName("vornameAbobox");
		nickNameWidget.addStyleName("nicknameAboBox");
		this.addStyleName("aboPinnwandBox");
		
		this.add(nutzerNameWidget);
		this.add(nickNameWidget);
	}
}