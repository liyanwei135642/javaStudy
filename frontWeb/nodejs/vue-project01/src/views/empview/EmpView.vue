<template>
    <div id="emp">
        <el-container style="height: 800px; border: 1px solid #eee">
            <el-header
                style="text-align: left; font-size: 35px;background-color: #B3C0D1;color: #333;line-height: 60px;">tlias智能学习辅助系统</el-header>
            <el-container>
                <el-aside width="210px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1']">
                        <el-submenu index='1'>
                            <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                            <el-menu-item index="1-1">部门管理</el-menu-item>
                            <el-menu-item index="1-2">员工管理</el-menu-item>
                            <!-- <el-menu-item-group>
                                <el-menu-item index="1-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="1-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                            </el-submenu> -->
                        </el-submenu>
                        <!-- <el-submenu index="2">
                            <template slot="title"><i class="el-icon-menu"></i>导航二</template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="2-1">选项1</el-menu-item>
                                <el-menu-item index="2-2">选项2</el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="2-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="2-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="2-4-1">选项4-1</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-submenu index="3">
                            <template slot="title"><i class="el-icon-setting"></i>导航三</template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="3-1">选项1</el-menu-item>
                                <el-menu-item index="3-2">选项2</el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="3-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="3-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="3-4-1">选项4-1</el-menu-item>
                            </el-submenu>
                        </el-submenu> -->
                    </el-menu>
                </el-aside>
                <el-main>
                    <!-- form表单 -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label="姓名">
                            <el-input v-model="searchForm.user" placeholder="姓名"></el-input>
                        </el-form-item>
                        <el-form-item label="性别">
                            <el-select v-model="searchForm.region" placeholder="性别">
                                <el-option label="男" value="1"></el-option>
                                <el-option label="女" value="2"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="入职时间">
                            <el-date-picker v-model="searchForm.entryTime" type="daterange" range-separator="至"
                                start-placeholder="开始日期" end-placeholder="结束日期">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                        </el-form-item>
                    </el-form>
                    <br>
                    <!-- table表格 -->
                    <el-table :data="tableData" border="1">
                        <el-table-column prop="name" label="姓名" width="140" align="center">
                        </el-table-column>
                        <el-table-column label="图像" width="120" align="center">
                            <!-- 插槽 获取到当前行的所有属性 -->
                            <template slot-scope="scope">
                                <!-- 获取当前行的属性用"scope.row.attribute"-->
                                <img :src="scope.row.image" alt="" width="120">
                                
                            </template>
                        </el-table-column>
                        <el-table-column label="性别" align="center">
                            <!-- 插槽 获取到当前行的所有属性 -->
                            <template slot-scope="scope">
                                <!-- 获取当前行的属性用"scope.row.attribute"-->
                                <!-- <span v-if="scope.row.gender==1">男</span>
                                <span v-else>女</span> -->
                                {{ scope.row.gender==1?"男":"女" }}
                            </template>
                        </el-table-column>
                        <el-table-column prop="job" label="职位" align="center">
                        </el-table-column>
                        <el-table-column prop="entrydate" label="入职时间" align="center">
                        </el-table-column>
                        <el-table-column prop="updatetime" label="最后操作时间" align="center">
                        </el-table-column>
                        <el-table-column label="操作" align="center">
                            <el-Button type="primary" size="mini">编辑</el-Button>
                            <el-Button type="danger" size="mini">删除</el-Button>
                        </el-table-column>
                    </el-table>
                    <br>
                    <!-- pagination分页 -->
                    <el-pagination background layout="sizes, prev, pager, next, jumper, total" :total="1000">
                    </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            tableData: [],
            searchForm: {
                user: '',
                region: '',
                entryTime: []
            }
        }
    },
    methods: {
        onSubmit: function () { alert(this.searchForm.region) },

    },
    mounted(){
        axios.get("http://yapi.smart-xwork.cn/mock/169327/emp/list").then((result)=>{
            this.tableData=result.data.data;
        })
    },

}
</script>


<style></style>