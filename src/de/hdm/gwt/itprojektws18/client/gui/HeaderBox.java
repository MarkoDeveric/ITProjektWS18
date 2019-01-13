package de.hdm.gwt.itprojektws18.client.gui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.hdm.gwt.itprojektws18.client.ClientsideSettings;
import de.hdm.gwt.itprojektws18.client.ITProjektWS18;
import de.hdm.gwt.itprojektws18.shared.PinnwandVerwaltungAsync;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;

public class HeaderBox extends HorizontalPanel {

	PinnwandVerwaltungAsync pinnwandVerwaltung = ClientsideSettings.getPinnwandVerwaltung();
	
	
	private HorizontalPanel inhalte = new HorizontalPanel();
	private ProfilBox profilBox = new ProfilBox();
	private Suchleiste suchLeiste = new Suchleiste();
	private VerticalPanel logoutEditPanel = new VerticalPanel();

	private Button logoutButton = new Button("Logout");
	private Button profilEditButton = new Button("Profil bearbeiten");

	private Label nicknameLbl = new Label("Neuer Nickname: ");
	private Label vornameLbl = new Label("Neuer Vorname: ");
	private Label nachnameLbl = new Label("Neuer Nachname: ");

	private TextArea nicknameTextbox = new TextArea();
	private TextBox vornameTextbox = new TextBox();
	private TextBox nachnameTextbox = new TextBox();

	private Button changeButton = new Button("Aenderungen speichern");
	private Button closeButton = new Button("Schließen");

	private EditForm dlgBox = new EditForm();

	


	public HeaderBox() {

	
		this.addStyleName("headerBox");

//		headerBox.add(EditPanel);
//		headerBox.add(inhalte);

		inhalte.add(profilBox);
		inhalte.add(suchLeiste);
		inhalte.add(logoutEditPanel);

		logoutEditPanel.add(logoutButton);
		logoutEditPanel.add(profilEditButton);

		logoutEditPanel.addStyleName("logoutEditPanel");
		logoutButton.addStyleName("logoutButton");
//		ProfilEditButton.addStyleName("profilEditButton");

		profilEditButton.addClickHandler(new ChangeClickHandler());
		
		this.add(inhalte);

		super.onLoad();
	}

	public class ChangeClickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {

			dlgBox.center();

		}

	}

	private class EditForm extends DialogBox {
		private VerticalPanel editPanel = new VerticalPanel();

		public EditForm() {

			closeButton.addClickHandler(new CloseClickHandler());

//			/**
//			 * Einfügen der in der Datenbank bereits vorhandenen Informationen
//			 */
//			vornameTextbox.setText("");
//			nachnameTextbox.setText("");
//			nicknameTextbox.setText("");

			editPanel.add(nicknameLbl);
			editPanel.add(nicknameTextbox);
			editPanel.add(vornameLbl);
			editPanel.add(vornameTextbox);
			editPanel.add(nachnameLbl);
			editPanel.add(nachnameTextbox);

			editPanel.add(changeButton);
			editPanel.add(closeButton);
			this.add(editPanel);
			changeButton.addClickHandler(new ProfilEditClickHandler());
		}

	}

	class ProfilEditClickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {

			Nutzer n = new Nutzer();

			// n.setId(Integer.parseInt(Cookies.getCookie("id")));
			n.setId(3);
			n.setVorname(vornameTextbox.getText());
			n.setNachname(nachnameTextbox.getText());
			n.setNickname(nicknameTextbox.getText());

			pinnwandVerwaltung.speichern(n, new NutzerEditCallback());

		}
	}

	public class NutzerEditCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler beim Bearbeiten des Nutzers: " + caught.getMessage());

		}

		@Override
		public void onSuccess(Void result) {
			Window.alert("Nutzer wurde erfolgreich geändert");
		}

	}

	class CloseClickHandler implements ClickHandler {

		public void onClick(ClickEvent event) {
			dlgBox.hide();
		}

	}
}
