/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.infosys.aic.soap.faults;

import org.apache.cxf.binding.soap.SoapFault;

@SuppressWarnings("serial")
public class UnknownProductFault extends SoapFault {

    public UnknownProductFault() {
        super("unknown product fault", ATTACHMENT_IO);
   


    }

}
