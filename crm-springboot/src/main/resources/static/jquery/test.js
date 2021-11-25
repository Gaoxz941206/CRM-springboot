/*
*   分页函数
*/
$("#activityPage").bs_pagination({
    currentPage:pageNo, //当前页
    rowsPerPage:pageSize,   //每页条数
    maxRowsPerPage: 20,     //每页最多显示条数
    totalPages:totalPages,  //总页数
    totalRows:totalRows,    //总条数
    visiblePageLinks: 3,    //显示卡片数量
    showGoToPage: true,    //每页最多显示条数
    showRowsPerPage: true,  //每页最多显示条数
    showRowsInfo: true,     //每页最多显示条数
    showRowsDefaultInfo: true,  //每页最多显示条数

    //回调函数，点击分页组件时出发
    onchange:function (event,data) {
        pageList(data.currentPage,data.rowsPerPage);
    }
});