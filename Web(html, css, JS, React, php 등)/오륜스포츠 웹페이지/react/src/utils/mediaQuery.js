import React from 'react';
import { useMediaQuery } from 'react-responsive';

const Mobile = ({ children }) => {
    const isMobile = useMediaQuery({
        query: "(max-width:767px)"
    });

    return isMobile && children;
}

const Desktop = ({ children }) => {
    const isDesktop = useMediaQuery({
        query: "(min-width:768px)"
    });

    return isDesktop && children;
}

export { Mobile, Desktop };