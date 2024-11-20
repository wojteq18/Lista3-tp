package eu.jpereira.trainings.designpatterns.creational.builder.model;

public interface ReportBuilder 
{
    void buildHeader(SaleEntry saleEntry);
    void buildBody(SaleEntry saleEntry); // Poprawiona literówka
    void buildFooter(SaleEntry saleEntry);
    Report getReport();
}