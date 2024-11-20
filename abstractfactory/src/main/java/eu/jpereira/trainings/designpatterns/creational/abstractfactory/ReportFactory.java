package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface ReportFactory
{
    ReportBody createReportBody();
    ReportHeader createReportHeader();
    ReportFooter createReportFooter();
}