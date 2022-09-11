package ija.ija2020.homework1.store;

import ija.ija2020.homework1.goods.Goods;
import ija.ija2020.homework1.goods.GoodsItem;
import ija.ija2020.homework1.goods.GoodsShelf;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreShelf implements GoodsShelf {

    private final HashMap<Goods, ArrayList<GoodsItem>> shelfContent = new HashMap<>();

    @Override
    public void put(GoodsItem goodsItem) {
        Goods goods = goodsItem.goods();
        if (this.shelfContent.containsKey(goods)) {
            this.shelfContent.get(goods).add(goodsItem);
        } else {
            ArrayList<GoodsItem> newGoodsItem  = new ArrayList<>();
            newGoodsItem.add(goodsItem);
            this.shelfContent.put(goods, newGoodsItem);
        }
    }

    @Override
    public boolean containsGoods(Goods goods) {
        ArrayList<GoodsItem> getGoods = this.shelfContent.get(goods);
        return getGoods != null && !getGoods.isEmpty();
    }

    @Override
    public GoodsItem removeAny(Goods goods) {
        ArrayList<GoodsItem> getGoods = this.shelfContent.get(goods);
        if (getGoods == null) {
            return null;
        } else {
            return getGoods.isEmpty() ? null : getGoods.remove(0);
        }
    }

    @Override
    public int size(Goods goods) {
        ArrayList<GoodsItem> sizeCheck = this.shelfContent.get(goods);
        if (sizeCheck == null) {
            return 0;
        } else {
            return sizeCheck.size();
        }
    }
}
