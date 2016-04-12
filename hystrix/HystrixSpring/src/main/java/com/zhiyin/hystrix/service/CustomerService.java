package com.zhiyin.hystrix.service;


import com.zhiyin.hystrix.dao.AddressDao;
import com.zhiyin.hystrix.dao.AddressHystrixCommand;
import com.zhiyin.hystrix.dao.ContactDao;
import com.zhiyin.hystrix.dao.ContactHystrixCommand;
import com.zhiyin.hystrix.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private ContactDao contactDao;
    private AddressDao addressDao;

    public Customer getCustomer(String customerId) {
        logger.info("Get Customer {}", customerId);
        try {
            Customer customer = new Customer(customerId, "xianlinbox");
            customer.setContact(new ContactHystrixCommand(customerId).execute());
            customer.setAddress(new AddressHystrixCommand(customerId).execute());
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getCustomerThroughDao(String customerId) {
        logger.info("Get Customer {}", customerId);
        try {
            Customer customer = new Customer(customerId, "xianlinbox");
            customer.setContact(contactDao.getContact(customerId));
            customer.setAddress(addressDao.getAddress(customerId));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
