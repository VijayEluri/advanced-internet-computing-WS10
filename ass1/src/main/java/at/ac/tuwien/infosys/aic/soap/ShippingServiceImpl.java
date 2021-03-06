package at.ac.tuwien.infosys.aic.soap;

import at.ac.tuwien.infosys.aic.soap.faults.UnknownAddressFault;
import at.ac.tuwien.infosys.aic.soap.faults.UnknownProductFault;
import at.ac.tuwien.infosys.aic.model.Address;
import at.ac.tuwien.infosys.aic.model.Item;
import at.ac.tuwien.infosys.aic.store.DataStore;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "at.ac.tuwien.infosys.aic.soap.ShippingService")
public class ShippingServiceImpl implements ShippingService {

    Logger log = Logger.getLogger("Shipping Service");

    @Override
    public String ship_items(Item[] items, Address address) {
        log.info("ship items called!");
        StringBuffer message = new StringBuffer("Sending items ");
        if (items == null) {
            log.log(Level.WARNING, "item was null");
            throw new UnknownProductFault();
        }
        for (Item item : items) {
            if (item.getProduct() != null) {
                message.append("'");
                message.append(item.getProduct().getName());
                message.append("', ");
            } else {
                log.log(Level.WARNING, "product was null");
                throw new UnknownProductFault();
            }
        }
        message.append("to ");

        if (DataStore.getInstance().getAddress(address.getId()) != null) {

            Address thisAddress = DataStore.getInstance().getAddress(address.getId());

            message.append(thisAddress.getStreet() + " "
                    + thisAddress.getHouse() + ", "
                    + thisAddress.getZipCode() + " "
                    + thisAddress.getCity());
        } else {
            log.log(Level.WARNING, "address fault");
            throw new UnknownAddressFault();
        }

        //message.append(address.toString());
        log.info(message.toString());
        return UUID.randomUUID().toString();
    }
}
