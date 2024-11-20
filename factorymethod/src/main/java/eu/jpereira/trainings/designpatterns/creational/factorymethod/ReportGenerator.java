package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    // Mapa przechowująca mapowanie typu raportu na fabryki
    private static final Map<String, ReportFactory> FACTORY_MAP = new HashMap<>(); //klucz String (np. "JSON", "XML", "HTML", "PDF") i wartość ReportFactory (np JSONReportFactory, XMLReportFactory, HTMLReportFactory, PDFReportFactory)

    static {
        // Rejestracja fabryk dla każdego typu raportu
        FACTORY_MAP.put("JSON", new JSONReportFactory());
        FACTORY_MAP.put("XML", new XMLReportFactory());
        FACTORY_MAP.put("HTML", new HTMLReportFactory());
        FACTORY_MAP.put("PDF", new PDFReportFactory());
    }

    /**
     * Generate a new report.
     * @param data The report data
     * @param type the type of report
     * @return the generated report, or null if type is unknown
     */
    public Report generateReport(ReportData data, String type) {
        // Pobranie fabryki na podstawie stringa
        ReportFactory factory = FACTORY_MAP.get(type);

        if (factory == null) {
            throw new IllegalArgumentException("Unknown report type: " + type);
        }

        // Użycie fabryki do stworzenia i wygenerowania raportu
        Report report = factory.createReport();
        report.generateReport(data);
        return report;
    }
}
