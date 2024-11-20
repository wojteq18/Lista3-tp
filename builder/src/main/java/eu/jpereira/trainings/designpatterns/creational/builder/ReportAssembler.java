package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.HTMLReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.JSONReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.XMLReportBuilder;

public class ReportAssembler {

    private ReportBuilder reportBuilder;
    private SaleEntry saleEntry;

    public void setSaleEntry(SaleEntry saleEntry) {
        this.saleEntry = saleEntry;
    }

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public Report getReport(String type) {
        switch (type) {
            case "JSON":
                this.setReportBuilder(new JSONReportBuilder());
                break;
            case "XML":
                this.setReportBuilder(new XMLReportBuilder());
                break;
            case "HTML":
                this.setReportBuilder(new HTMLReportBuilder());
                break;
            default:
                throw new IllegalArgumentException("Unsupported report type: " + type);
        }
        return this.generateReport();
    }

    public Report generateReport() {
        if (reportBuilder == null) {
            throw new IllegalStateException("ReportBuilder is not set.");
        }
        if (saleEntry == null) {
            throw new IllegalStateException("SaleEntry is not set.");
        }

        reportBuilder.buildHeader(saleEntry);
        reportBuilder.buildBody(saleEntry);
        reportBuilder.buildFooter(saleEntry);

        return reportBuilder.getReport();
    }
}