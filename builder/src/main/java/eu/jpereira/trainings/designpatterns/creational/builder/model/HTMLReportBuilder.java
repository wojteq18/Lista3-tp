package eu.jpereira.trainings.designpatterns.creational.builder.model;

// Import odpowiednich klas
//import eu.jpereira.trainings.designpatterns.creational.builder.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;



public class HTMLReportBuilder implements ReportBuilder {
    private Report report;

    public HTMLReportBuilder() {
        this.report = new Report();
        this.report.setReportBody(new HTMLReportBody());
    }

    @Override
public void buildHeader(SaleEntry saleEntry) {
    HTMLReportBody body = (HTMLReportBody) report.getReportBody();
    body.putContent("<span class=\"customerName\">");
    body.putContent(saleEntry.getCustomer().getName());
    body.putContent("</span><span class=\"customerPhone\">");
    body.putContent(saleEntry.getCustomer().getPhone());
    body.putContent("</span>");
}
@Override
public void buildBody(SaleEntry saleEntry) {
    HTMLReportBody body = (HTMLReportBody) report.getReportBody();
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
    body.putContent("</items>");
}
@Override
public void buildFooter(SaleEntry saleEntry) {
    // Footer is not necessary
}

    /*@Override
    public void buildFooter(SaleEntry saleEntry) {
        HTMLReportBody body = (HTMLReportBody) report.getReportBody();
        body.putContent("<div class=\"footer\">");
        body.putContent("<span>End of Report</span>");
        body.putContent("</div>");
    }*/

    @Override
    public Report getReport() {
        return this.report;
    }
}