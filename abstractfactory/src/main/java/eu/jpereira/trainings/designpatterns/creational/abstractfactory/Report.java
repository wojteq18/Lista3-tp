/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import java.util.HashMap;
import java.util.Map;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFactory;


public class Report {

	private String reportContent;
	private ReportBody body;
	private ReportFooter footer;
	private ReportHeader header;
	private String reportType;
	private static final Map<String, ReportFactory> factory_map = new HashMap<>();
	

	
	
	/**
	 * @param string
	 */

	static 
	{
		factory_map.put("JSON", new JSONReportFactory());
		factory_map.put("XML", new XMLReportFactory());
	}	
	
	public Report(String type)
	{
		ReportFactory factory = factory_map.get(type);
		this.body = factory.createReportBody();
		this.footer = factory.createReportFooter();
		this.header = factory.createReportHeader();
	}

	public String getReportContent() {
        return this.body.getType() + this.header.getType() + this.footer.getType();
    }

    // Getter for ReportBody
    public ReportBody getBody() {
        return this.body;
    }

    // Getter for ReportHeader
    public ReportHeader getHeader() {
        return this.header;
    }

    // Getter for ReportFooter
    public ReportFooter getFooter() {
        return this.footer;
    }
}
