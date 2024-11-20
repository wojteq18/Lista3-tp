package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class XMLReportFactory implements ReportFactory
{
    @Override
    public Report createReport()
    {
        return new XMLReport();
    }
}