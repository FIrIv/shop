package pro.sky.shop.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// БД товаров магазина
@Repository
@Scope("singleton")
public class DBGoods {
    private Set<Integer> goods;
    private static int numberOfIDes = 0;

    public DBGoods () {
        goods = new HashSet<>();
        for (int i=0; i<1000; i++) {
            numberOfIDes += 1;
            goods.add(numberOfIDes);
        }
    }

    public Set<Integer> getGoods() {
        return goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBGoods dbGoods = (DBGoods) o;
        return Objects.equals(goods, dbGoods.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods);
    }
}
