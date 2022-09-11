package ija.ija2020.homework1.store;

import ija.ija2020.homework1.goods.Goods;
import ija.ija2020.homework1.goods.GoodsItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class StoreGoods implements Goods {

    private final String itemName;
    private final ArrayList<GoodsItem> newItemGoods = new ArrayList<>();

    public StoreGoods(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StoreGoods that = (StoreGoods) obj;
        return itemName.equals(that.itemName);
    }

    @Override
    public String getName() {
        return this.itemName;
    }

    @Override
    public boolean addItem(GoodsItem goodsItem) {
        return this.newItemGoods.add(goodsItem);
    }

    @Override
    public GoodsItem newItem(LocalDate localDate) {
        GoodsItem newGoodsItem = new StoreGoodsItem(this, localDate);
        this.newItemGoods.add(newGoodsItem);
        return newGoodsItem;
    }

    @Override
    public boolean remove(GoodsItem goodsItem) {
        return this.newItemGoods.remove(goodsItem);
    }

    @Override
    public boolean empty() {
        return newItemGoods.size() == 0;
    }

    @Override
    public int size() {
        return newItemGoods.size();
    }
}
