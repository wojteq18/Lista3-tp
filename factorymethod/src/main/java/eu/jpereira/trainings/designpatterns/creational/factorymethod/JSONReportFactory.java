package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class JSONReportFactory implements ReportFactory
{
    @Override
    public Report createReport()
    {
        return new JSONReport();
    }
}