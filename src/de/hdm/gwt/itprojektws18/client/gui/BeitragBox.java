package de.hdm.gwt.itprojektws18.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.hdm.gwt.itprojektws18.client.ClientsideSettings;
import de.hdm.gwt.itprojektws18.shared.PinnwandVerwaltungAsync;
import de.hdm.gwt.itprojektws18.shared.bo.Beitrag;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;
import de.hdm.gwt.itprojektws18.shared.bo.Pinnwand;

import java.sql.Timestamp;
import java.util.Vector;

public class BeitragBox extends HorizontalPanel {

	// Panels fuer die Darstellung der BeitragBox
	private HorizontalPanel BeitragPanel = new HorizontalPanel();
	private HorizontalPanel NickTimePanel = new HorizontalPanel();
	private VerticalPanel InhaltPanel = new VerticalPanel();
	private FlowPanel InfoPanel = new FlowPanel();
	private HorizontalPanel ButtonPanel = new HorizontalPanel();

	// benoetigte Label
	private Label beitragInhalt = new Label();
	private Label nickname = new Label();
	private Label erstellZeitpunkt = new Label();
	private Label kommentarAnzahlText = new Label("30 Kommentare");
	private Label likeAnzahlText = new Label("85 Likes");

	// benoetigte Buttons
//	private Button beitragStatistikButton = new Button("Beitragstatistik");
	private Button beitragBearbeitenButton = new Button("Beitrag bearbeiten");
	private Button likeButton = new Button("Gefällt mir!");
	private Button kommentierButton = new Button("Sag etwas dazu!");

	PinnwandVerwaltungAsync pinnwandVerwaltung = ClientsideSettings.getPinnwandVerwaltung();
	ClientsideSettings clientSettings = new ClientsideSettings();
	
	Pinnwand pinnwand = new Pinnwand();
	
	String Text;
	
	public BeitragBox() {
		
	}
	
	
	public BeitragBox(Pinnwand p) {

		this.pinnwand = p;
		
		
		
		
		BeitragPanel.setSpacing(2);
		InhaltPanel.setSpacing(4);
		ButtonPanel.setSpacing(5);
		NickTimePanel.setSpacing(2);
		
	}
	
	public void befuelleNicklabel (String nicknameString) {
		
		this.nickname.setText(nicknameString);
		
	}
	
	public void befuelleErstellzeitpunkt (String erstellzeitpunkt) {
		
		this.erstellZeitpunkt.setText(erstellzeitpunkt);
		
	}
	
	public void befuelleInhalt (String inhalt) {
		
		this.beitragInhalt.setText(inhalt);
	}

	public void onLoad() {


		
		// StyleName für das Styling aller BeitragBoxen mit CSS
		this.addStyleName("beitragBox");
		
		
		this.add(BeitragPanel);
		
		// Panels hinzufügen 
		BeitragPanel.add(InhaltPanel);
		BeitragPanel.add(InfoPanel);
		BeitragPanel.add(ButtonPanel);

		
		//NickTimePanel gestalten
		NickTimePanel.add(nickname);
		NickTimePanel.add(erstellZeitpunkt);
		
		// InhaltPanel gestalten
		InhaltPanel.add(NickTimePanel);
		InhaltPanel.add(beitragInhalt);
		InhaltPanel.add(ButtonPanel);
		
		// ButtonPanel gestalten
		ButtonPanel.add(beitragBearbeitenButton);
		ButtonPanel.add(likeButton);
		ButtonPanel.add(likeAnzahlText);
		ButtonPanel.add(kommentierButton);
		ButtonPanel.add(kommentarAnzahlText);

		// StyleNames für das Styling mit CSS hinzufügen
		BeitragPanel.addStyleName("beitragBox");
		beitragBearbeitenButton.addStyleName("beitragBearbeitenButton");
		likeButton.addStyleName("likeButton");
		kommentierButton.addStyleName("kommentierButton");
		InfoPanel.addStyleName("infoPanel");
		InhaltPanel.addStyleName("inhaltPanel");
		beitragInhalt.addStyleName("beitragInhalt");
		nickname.addStyleName("nickname");
		erstellZeitpunkt.addStyleName("erstellZeitpunkt");
		ButtonPanel.addStyleName("ButtonPanel");
		
		RootPanel.get("InhaltDiv").add(BeitragPanel);
	}

	/**
	 * Hier werden im Folgenden die inneren Klassen implementiert, die das Interface
	 * Clickhandler implementieren, um entsprechenden erstellten Buttons
	 * <code>ClickEvents</code> zuzuweisen.
	 * 
	 * @author florian
	 */

	class LikesAnzeigen implements ClickHandler {

		public void onClick(ClickEvent event) {

		}

	}

	class LikeErstellen implements ClickHandler {

		public void onClick(ClickEvent event) {

		}

	}

	class KommentareAnzeigen implements ClickHandler {

		public void onClick(ClickEvent event) {

		}

	}

	class KommentarErstellen implements ClickHandler {

		public void onClick(ClickEvent event) {

		}

	}
				
			
		
	}

