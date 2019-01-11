package de.hdm.gwt.itprojektws18.client.gui;

import java.sql.Timestamp;
import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.gwt.itprojektws18.client.ClientsideSettings;
import de.hdm.gwt.itprojektws18.shared.PinnwandVerwaltungAsync;
import de.hdm.gwt.itprojektws18.shared.bo.Beitrag;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;
import de.hdm.gwt.itprojektws18.shared.bo.Pinnwand;

public class ErstelleBeitragBox extends HorizontalPanel {

	private HorizontalPanel postingPanel = new HorizontalPanel();
	private TextArea erstelleBeitragFeld = new TextArea();
	private Button postingButton = new Button("Posten");

	PinnwandVerwaltungAsync pinnwandVerwaltung = ClientsideSettings.getPinnwandVerwaltung();
	ClientsideSettings clientSettings = new ClientsideSettings();

	private Pinnwand pinnwand = new Pinnwand();

	Nutzer nutzer = new Nutzer();

//	BeitragBox bBox = new BeitragBox(pinnwand);

//	public Vector<BeitragBox> befuellteBBoxen = new Vector<BeitragBox>();

	public ErstelleBeitragBox() {

	}

	public ErstelleBeitragBox(Pinnwand p) {

		this.pinnwand = p;
		postingPanel.setSpacing(2);
	}

	public void onLoad() {
		this.addStyleName("erstelleBeitragBox");
		this.add(postingPanel);

		postingPanel.add(erstelleBeitragFeld);
		postingPanel.add(postingButton);

		erstelleBeitragFeld.addStyleName("erstelleBeitragFeld");
		postingButton.addStyleName("submitButton");

		postingButton.addClickHandler(new postingButtonClickHandler());

		RootPanel.get("BeitragDiv").add(postingPanel);

	}

	class postingButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			Nutzer nutzer = new Nutzer();
//			nutzer.setId(Integer.parseInt(Cookies.getCookie("id")));

			nutzer.setId(3);

			Pinnwand pinnwand = new Pinnwand();
			pinnwand.setId(nutzer.getId());

			Timestamp erstellzeitpunkt = null;

			String text = "'" + erstelleBeitragFeld.getText() + "'";

			pinnwandVerwaltung.erstelleBeitrag(pinnwand, text, erstellzeitpunkt, nutzer, new BeitragAnlegenCallback());
		}

		public class BeitragAnlegenCallback implements AsyncCallback<Beitrag> {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler beim Anlegen des Beitrags: " + caught.getMessage());

			}

			@Override
			public void onSuccess(Beitrag result) {
				Window.alert("Der Beitrag wurde erfolgreich angelegt.");

//				Pinnwand p = new Pinnwand();
//				
//				p.setId(result.getPinnwandFK());
//				
//				BeitragBox bBox = new BeitragBox(p);
//				
				Nutzer n = new Nutzer();
				
				n.setId(result.getNutzerFK());
//				
//				String nicknameString = "@ " + n.getNickname();
//				
//				bBox.befuelleNicklabel(nicknameString);
//				
////				pinnwandVerwaltung.getNutzerbyID(1, new NutzerInfosCallBack());
//
//				String erstellZPString = "" + result.getErstellZeitpunkt() + "";
//
//				bBox.befuelleErstellzeitpunkt(erstellZPString);
//
//				String textString = result.getText();
//
//				bBox.befuelleInhalt(textString);

//				befuellteBBoxen.add(bBox);

				PinnwandBox pBox = new PinnwandBox(n.getId());
				
//				for(int i =0; i <befuellteBBoxen.size(); i++) {
//					pBox.add(befuellteBBoxen.elementAt(i));
//				}
			}

		}

//		public class NutzerInfosCallBack implements AsyncCallback<Nutzer> {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Fehler beim Auslesen der Nutzer Informationen: " + caught.getMessage());
//
//			}
//
//			@Override
//			public void onSuccess(Nutzer result) {
//
//				String nicknameString = "@ " + result.getNickname();
//
//				bBox.befuelleNicklabel(nicknameString);
//
//			}
//
//		}

	}
}
