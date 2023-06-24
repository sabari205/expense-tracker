package org.sabari.expensetracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import org.sabari.expensetracker.models.Expense;
import org.sabari.expensetracker.dto.ExpenseDTO;

@Mapper(componentModel="spring")
public interface ExpenseDTOtoEntityMapper {


	Expense dtoToEntityMapper(ExpenseDTO source);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void dtoToEntityMapper(ExpenseDTO source, @MappingTarget Expense dest);

}