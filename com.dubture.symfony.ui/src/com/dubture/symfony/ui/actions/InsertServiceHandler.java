package com.dubture.symfony.ui.actions;

import java.util.ArrayList;
import java.util.List;

import com.dubture.symfony.core.model.Service;
import com.dubture.symfony.core.model.SymfonyModelAccess;

public class InsertServiceHandler extends BaseTextInsertionHandler
{

    @Override
    protected List<String[]> getInput()
    {
        SymfonyModelAccess modelAccess = SymfonyModelAccess.getDefault();
        List<Service> services = modelAccess.findServices(project.getPath());
        List<String[]> input = new ArrayList<String[]>();
        
        for (Service service : services) {
            String display = service.getId() + " - " + service.getClassName();
            
            input.add(new String[]{display, service.getId()});
        }
        
        return input;
    }

    @Override
    protected String getTitle()
    {
        return "Select a service ID to insert";
    }

}
