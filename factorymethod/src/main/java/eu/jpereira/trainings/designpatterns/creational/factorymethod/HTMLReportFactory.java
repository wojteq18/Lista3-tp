package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class HTMLReportFactory implements ReportFactory
{
    @Override
    public Report createReport()
    {
        return new HTMLReport();
    }
}