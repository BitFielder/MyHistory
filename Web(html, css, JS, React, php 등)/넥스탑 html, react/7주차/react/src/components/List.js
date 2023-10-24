import React from 'react'
import styled from 'styled-components'
import Item from './Item';
import { useTodoState } from '../TodoContext';

const ListBlock = styled.div`
    flex: 1;
    padding: 20px 32px;
    padding-bottom: 48px;
    overflow-y: auto;
`;

const List = () => {
    const todos = useTodoState();
    return (
        <ListBlock>
            {todos.map(todo => (
                <Item
                    key={todo.id}
                    id={todo.id}
                    text={todo.text}
                    done={todo.done}
                />   
            ))}
        </ListBlock>
    )
}

export default List;