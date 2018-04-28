package main.userinterface;

import java.awt.event.ActionEvent;
import main.assetsubsys.AssetSystem;

public class NewAssetForm extends Form {

    public NewAssetForm(Window parent) {
        super(parent);
        
        setGridLayout(3, 3);
        
        addTextField("name", "name of new asset");
        addTextField("type", "type");
        addTextField("value", "value");
        
        addPlaceholders(3);
        
        addButton("back", "Back");
        addTextField("date", "date aquired (mm-dd-yyyy)");
        addButton("new_asset", "Add New Asset");
        
        AssetSystem.createNewAssetController(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "new_asset":
                AssetSystem.getNewAssetController().validate();
                break;
            case "back":
                goBack();
                break;
        }
    }

}