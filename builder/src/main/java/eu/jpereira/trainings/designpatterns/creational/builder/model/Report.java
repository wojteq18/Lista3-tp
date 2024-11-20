package eu.jpereira.trainings.designpatterns.creational.builder.model;

public class Report {

    private ReportBody reportBody;

    /**
     * Ustawia ciało raportu.
     *
     * @param reportBody Obiekt reprezentujący ciało raportu.
     */
    public void setReportBody(ReportBody reportBody) {
        this.reportBody = reportBody;
    }

    /**
     * @return Obiekt reprezentujący ciało raportu.
     */
    public ReportBody getReportBody() {
        return this.reportBody;
    }

    /**
     * @return 
     */
    public Object getAsString() {
        return this.reportBody.getAsString();
    }
}