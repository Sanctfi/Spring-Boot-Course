package com.ltp.globalsuperstore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {
    
    List<Item> inventory = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getInventoryIndex(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : inventory.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("inventory", inventory);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        int index = getInventoryIndex(item.getId());
        String status = Constants.SUCCESS_STATUS;

        if (index == Constants.NOT_FOUND) {
            inventory.add(item);
        } else if(within5Days(item.getDate(), inventory.get(index).getDate())) {
            inventory.set(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }

        System.out.println(inventory.toString());
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    public int getInventoryIndex(String id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int)(TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}