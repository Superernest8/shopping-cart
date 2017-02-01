package com.example.dell.myshoppingapp2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();


    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("SIMS", res
                    .getDrawable(R.drawable.sims),
                    "The Sims 4 is a life simulation video game developed by Maxis and The Sims Studio and published by Electronic Arts. The Sims 4 was originally announced on May 6, 2013, and was released in North America on September 2, 2014 for Microsoft Windows.[1] A Mac compatible version of the software was made available for digital download on February 17, 2015.[2] The Sims 4 is the first PC game to top all-format charts in two years.[3] The game has received mixed reviews since its release.[4] Since its launch, it became the best selling PC game of 2014 and 2015. The Sims 4 has sold over 5 million copies worldwide.[5]\n" +
                            "\n" +
                            "The game has the same concept as its predecessor, The Sims 3; players control their Sims in various activities and can form relationships. The game, like the rest of the series, does not have a defined final goal; gameplay is nonlinear. The Create-a-Sim and Build Mode tools have been redesigned to allow more versatility when creating game content. Emotional state plays a larger role in game play than in previous games in the series, with effects on social interaction, user interface, and personality.[6][7]", 29.99));
            catalog.add(new Product("Barbie", res
                    .getDrawable(R.drawable.barbie),
                    "Play with barbie and dress her up as much as u can...enjoy the game and dont forget to give us feedback :)", 24.99));
            catalog.add(new Product("Assasins Creed", res
                    .getDrawable(R.drawable.ass),
                    "Assassin's Creed is an action-adventure video-game series created by Ubisoft that consists of nine main games and a number of supporting materials.The games are set in a fictional history of real-world events and follows the centuries-old struggle between the Assassins, who fight for peace with free will, and the Templars, who desire peace through control. The main games in the franchise were developed by Ubisoft Montreal for the single player and Ubisoft Annecy for the multiplayer, with the handheld titles developed by Gameloft and Gryptonite Studios, with additional development by Ubisoft Montreal. The series has been well received by the public and critics, and has sold over 93 million copies as of June 2015, becoming Ubisoft's best selling franchise.[39] The series took inspiration from the novel Alamut by the Slovenian writer Vladimir Bartol,[40] while building upon concepts from the Prince of Persia series.", 24.99));
            catalog.add(new Product("Left 4 Dead", res
                    .getDrawable(R.drawable.left),
                    "Its a zombie game...Beware the zomies might eat your brains off....bruhahhahaha", 24.99));
            catalog.add(new Product("Switch", res
                    .getDrawable(R.drawable.switchbook),
                    "Switch by Chip Heath and Dan Heath", 24.99));
            catalog.add(new Product("Watchmen", res
                    .getDrawable(R.drawable.watchmen),
                    "Watchmen by Alan Moore and Dave Gibbons", 14.99));
            catalog.add(new Product("Micheal Jackson", res
                    .getDrawable(R.drawable.mj),
                    "The King of POP", 94.99));
            catalog.add(new Product("Xiomi MI", res
                    .getDrawable(R.drawable.mi),
                    "Cheap and has all the features", 4.99));
            catalog.add(new Product("Iphone", res
                    .getDrawable(R.drawable.iphone),
                    "Its elegant", 100.99));
            catalog.add(new Product("Dead Or Alive", res
                    .getDrawable(R.drawable.deadoralive),
                    "DOA: Dead or Alive is a 2006 ensemble martial arts film loosely based on the Tecmo/Team Ninja fighting game series Dead or Alive.", 14.99));
        }

        return catalog;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }


}