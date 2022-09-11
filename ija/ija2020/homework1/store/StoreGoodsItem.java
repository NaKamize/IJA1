package ija.ija2020.homework1.store;

import ija.ija2020.homework1.goods.Goods;
import ija.ija2020.homework1.goods.GoodsItem;

import java.time.LocalDate;

public class StoreGoodsItem implements GoodsItem {

    Goods goodsName;
    LocalDate goodsDate;

    public StoreGoodsItem(Goods goods1, LocalDate goodsDate) {
        this.goodsName = goods1;
        this.goodsDate = goodsDate;
    }

    @Override
    public Goods goods() {
        return this.goodsName;
    }

    @Override
    public boolean sell() {
        return goodsName.remove(this);
    }
}
