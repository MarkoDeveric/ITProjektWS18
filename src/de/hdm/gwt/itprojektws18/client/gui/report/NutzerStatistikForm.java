package de.hdm.gwt.itprojektws18.client.gui.report;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

import de.hdm.gwt.itprojektws18.client.ClientsideSettings;
import de.hdm.gwt.itprojektws18.client.NutzerStatistikCallback;
//import de.hdm.gwt.itprojektws18.shared.PinnwandVerwaltungAsync;
import de.hdm.gwt.itprojektws18.shared.ReportGeneratorAsync;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;

public class NutzerStatistikForm extends HorizontalPanel {

	/**
	 * Erstellung benötigter GUI-Elemente
	 */
	private Button reportStart = new Button("Report Starten");
	private Label startDatum = new Label("Startdatum");
	private DateBox dateBox = new DateBox();
	private Label endDatum = new Label("Enddatum");
	private DateBox endDateBox = new DateBox();
	private FlexTable ft = new FlexTable();
	private ListBox listBox = new ListBox();
	private Label nn= new Label("Nickname:");
	
	private VerticalPanel vpanel = new VerticalPanel();
	private DateTimeFormat dtf = DateTimeFormat.getFormat("dd.MM.yyyy");
	
	/**
	 * Erzeugen eines Reportgenerator-Objekts um eine Report Verwaltung zu initialisieren
	 */
	private ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
	
	public NutzerStatistikForm() {
		
		ft.setWidget(0, 0, nn);
		ft.setWidget(0, 1, listBox);
		ft.setWidget(2, 0, startDatum);
		ft.setWidget(2, 1, dateBox);
		ft.setWidget(3, 0, endDatum);
		ft.setWidget(3, 1, endDateBox);
		ft.setWidget(4, 0, reportStart);

		dateBox.setFormat(new DateBox.DefaultFormat(dtf));
		endDateBox.setFormat(new DateBox.DefaultFormat(dtf));

		dateBox.addValueChangeHandler(new StartDatum());
		endDateBox.addValueChangeHandler(new EndDatum());

		reportStart.addClickHandler(new ReportStartClickhandler());

		reportverwaltung.getAllNutzer(new GetAllNutzerCallback());
		
		this.add(ft);
	}

	/**
	 * Callback Aufruf zum Abruf aller Nutzer
	 * Ergebnisvektor Vector<Nutzer> wird der ListBox hinzugefügt
	 *
	 */
	private class GetAllNutzerCallback implements AsyncCallback<Vector<Nutzer>>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler beim Abrufen der Nutzer: " + caught.getMessage());
			
		}

		@Override
		public void onSuccess(Vector<Nutzer> result) {
			for (Nutzer nutzer : result) { 
				listBox.addItem(nutzer.getNickname());
			}
		}
		
	}
	
	/**
	 * Implementierung des ClickHandler für den "Report starten"-Button
	 */
	private class ReportStartClickhandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if(listBox.getSelectedValue().equals("")) {
				Window.alert("Wählen Sie einen Nutzer aus!");	
			} else {
				vpanel.clear();
				vpanel.add(new NutzerStatistikCallback(listBox.getSelectedValue(), dateBox.getValue(), endDateBox.getValue()));
				RootPanel.get("contentReport").add(vpanel);		
			}
		}

	}

	/**
	 * Implementierung des ValueChangeHandler für das Startdatum
	 *
	 */
	private class StartDatum implements ValueChangeHandler<Date> {

		@Override
		public void onValueChange(ValueChangeEvent<Date> event) {
			if (dateBox.getValue().after(endDateBox.getValue())) {
				Window.alert("Startdatum muss vor dem Enddatum liegen!");
				dateBox.setValue(null);
			}
		}

	}

	/**
	 * Implementierung des ValueChangeHandler für das Enddatum
	 *
	 */
	private class EndDatum implements ValueChangeHandler<Date> {
		@Override
		public void onValueChange(ValueChangeEvent<Date> event) {
			if (dateBox.getValue().after(endDateBox.getValue())) {
				Window.alert("Startdatum muss vor dem Enddatum liegen!");
				endDateBox.setValue(null);
			}
		}
	}
}
