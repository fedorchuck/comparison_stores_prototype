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
import com.github.fedorchuck.comparison_stores_prototype.domainmodels.StoryOfChangePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by fedorchuck on 15.05.16.
 */
@Repository
public class JdbcStoryOfChangePriceRepository implements JdbcRepository<StoryOfChangePrice> {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcStoryOfChangePriceRepository(JdbcOperations jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public void add(StoryOfChangePrice o) {
        jdbc.queryForList("insert into storyofchangeprice " +
                        "(m1, m2, m3, m4) values (?,?,?,?) RETURNING id",
                o.getM1(),
                o.getM2(),
                o.getM3(),
                o.getM4()
        );
        //return user;
    }

    @Override
    public List<StoryOfChangePrice> getAll() {
        try {
            return jdbc.query("select * from storyofchangeprice", (rs, rowNum) -> new StoryOfChangePrice(
                    rs.getInt("id"),rs.getDouble("m1"),rs.getDouble("m2"),rs.getDouble("m3"),rs.getDouble("m4")
            ));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

}
