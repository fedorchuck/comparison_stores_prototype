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

package com.github.fedorchuck.comparison_stores_prototype.web.controllers;

import com.github.fedorchuck.comparison_stores_prototype.dao.impl.postgresql.JdbcProductRepository;
import com.github.fedorchuck.comparison_stores_prototype.dao.impl.postgresql.JdbcStoreRepository;
import com.github.fedorchuck.comparison_stores_prototype.dao.impl.postgresql.JdbcStoryOfChangePriceRepository;
import com.github.fedorchuck.comparison_stores_prototype.domainmodels.Product;
import com.github.fedorchuck.comparison_stores_prototype.domainmodels.Store;
import com.github.fedorchuck.comparison_stores_prototype.domainmodels.StoryOfChangePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by fedorchuck on 15.05.16.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    private JdbcProductRepository productRepository;
    private JdbcStoreRepository storeRepository;
    private JdbcStoryOfChangePriceRepository storyOfChangePriceRepository;

    @Autowired
    public HomeController(JdbcProductRepository productRepository,
                          JdbcStoreRepository storeRepository,
                          JdbcStoryOfChangePriceRepository storyOfChangePriceRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.storyOfChangePriceRepository = storyOfChangePriceRepository;
    }

    @RequestMapping(method = GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("index");

        List<Product> products = productRepository.getAll();
        List<Store> stores = storeRepository.getAll();
        List<StoryOfChangePrice> storyOfChangePrices = storyOfChangePriceRepository.getAll();

        model.addObject("producers", products);
        model.addObject("stores", stores);
        model.addObject("StoryOfChangePrice", storyOfChangePrices);

        return model;
    }
}
