package de.hdm.gwt.itprojektws18.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.hdm.gwt.itprojektws18.shared.bo.Nutzer;
import de.hdm.gwt.itprojektws18.shared.report.BeitragStatistikReport;
import de.hdm.gwt.itprojektws18.shared.report.NutzerStatistikReport;
import de.hdm.gwt.itprojektws18.shared.bo.Beitrag;

@RemoteServiceRelativePath("reportGenerator")
public interface ReportGenerator extends RemoteService {

	public void init() throws IllegalArgumentException;

	Vector<Nutzer> getNutzerByName(String vorname, String nachname) throws IllegalArgumentException;

	Vector<Nutzer> getNutzerByNickname(String nickname) throws IllegalArgumentException;

	Nutzer findNutzerByEmail(String mail) throws IllegalArgumentException;

	Vector<Beitrag> getBeitrageByNutzer(Nutzer n) throws IllegalArgumentException;

	Nutzer getNutzerById(int nutzerID) throws IllegalArgumentException;

	NutzerStatistikReport createNutzerStatistikReport(String nickname, Date firstDate, Date lastDate);

	Vector<Nutzer> getAllNutzer() throws IllegalArgumentException;

	BeitragStatistikReport createBeitragStatistikReport(Date startDate, Date endDate);

}
