/*
 * The GNU General Public Licence
 *
 * Copyright (c) 2016 by Volodymyr Fedorchuk <vl.fedorchuck@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  @license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 */

package com.github.fedorchuck.comparison_stores_prototype.dao.impl.postgresql;

import com.github.fedorchuck.comparison_stores_prototype.dao.JdbcRepository;
import com.github.fedorchuck.comparison_stores_prototype.domainmodels.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by fedorchuck on 15.05.16.
 */
@Repository
public class JdbcProductRepository implements JdbcRepository<Product> {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcProductRepository(JdbcOperations jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public void add(Product o) {
        jdbc.queryForList("insert into product " +
                        "(name) values (?) RETURNING id",
                o.getName()
        );
        //return user;
    }

    @Override
    public List<Product> getAll() {
        try {
            return jdbc.query("select * from product", (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name")));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

}
