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

package com.github.fedorchuck.comparison_stores_prototype.dao;

import java.util.List;

/**
 * Created by fedorchuck on 15.05.16.
 */
public interface JdbcRepository<T> {
    List<T> getAll();
    void add(T o);
}
