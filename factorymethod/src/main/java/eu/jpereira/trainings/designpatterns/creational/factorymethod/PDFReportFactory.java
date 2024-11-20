package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class PDFReportFactory implements ReportFactory
{
    @Override
    public Report createReport()
    {
        return new PDFReport();
    }
}