package eu.jpereira.trainings.designpatterns.creational.builder.model;

import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

public class XMLReportBuilder implements ReportBuilder {
    private Report report;

    public XMLReportBuilder() {
        this.report = new Report();
        this.report.setReportBody(new XMLReportBody());
    }

    @Override
    public void buildHeader(SaleEntry saleEntry) {
        XMLReportBody body = (XMLReportBody) report.getReportBody();
        body.putContent("<sale><customer><name>");
        body.putContent(saleEntry.getCustomer().getName());
        body.putContent("</name><phone>");
        body.putContent(saleEntry.getCustomer().getPhone());
        body.putContent("</phone></customer>");
    }

    @Override
    public void buildBody(SaleEntry saleEntry) {
        XMLReportBody body = (XMLReportBody) report.getReportBody();
        body.putContent("<items>");
        for (SoldItem item : saleEntry.getSoldItems()) {
            body.putContent("<item><name>");
            body.putContent(item.getName());
            body.putContent("</name><quantity>");
            body.putContent(String.valueOf(item.getQuantity()));
            body.putContent("</quantity><price>");
            body.putContent(String.valueOf(item.getUnitPrice()));
            body.putContent("</price></item>");
        }
        body.putContent("</items></sale>");
    }

    @Override
    public void buildFooter(SaleEntry saleEntry) {
        // XML footer is not necessary
    }

    @Override
    public Report getReport() {
        return this.report;
    }
}