package eu.jpereira.trainings.designpatterns.creational.builder.model;

// Import odpowiednich klas
//import eu.jpereira.trainings.designpatterns.creational.builder.ReportBuilder;
import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;

public class JSONReportBuilder implements ReportBuilder {
    private Report report;

    public JSONReportBuilder() {
        this.report = new Report();
        this.report.setReportBody(new JSONReportBody());
    }

    @Override
    public void buildHeader(SaleEntry saleEntry) {
        JSONReportBody body = (JSONReportBody) report.getReportBody();
        body.addContent("sale:{customer:{");
        body.addContent("name:\"");
        body.addContent(saleEntry.getCustomer().getName());
        body.addContent("\",phone:\"");
        body.addContent(saleEntry.getCustomer().getPhone());
        body.addContent("\"}");
    }

    @Override
public void buildBody(SaleEntry saleEntry) {
    JSONReportBody body = (JSONReportBody) report.getReportBody();
    body.addContent(",items:[");
    Iterator<SoldItem> iterator = saleEntry.getSoldItems().iterator();
    while (iterator.hasNext()) {
        SoldItem item = iterator.next();
        body.addContent("{name:\"");
        body.addContent(item.getName());
        body.addContent("\",quantity:");
        body.addContent(String.valueOf(item.getQuantity()));
        body.addContent(",price:");
        body.addContent(String.valueOf(item.getUnitPrice()));
        body.addContent("}");
        if (iterator.hasNext()) {
            body.addContent(",");
        }
    }
    body.addContent("]}");
}


    @Override
    public void buildFooter(SaleEntry saleEntry) {
        // JSON footer is not necessary
    }

    @Override
    public Report getReport() {
        return this.report;
    }
}