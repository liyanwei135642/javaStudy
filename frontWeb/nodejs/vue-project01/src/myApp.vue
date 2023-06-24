<template>
  <div id="myApp">
    <div style="text-align: center;">
        <el-row>
          <router-link to="/">
            <el-button type="primary">Home</el-button>
          </router-link> |
          <router-link to="/button">
            <el-button type="primary">Button</el-button>
          </router-link> |
          <router-link to="/dialog">
            <el-button type="primary">Dialog</el-button>
          </router-link> |
          <router-link to="/pagination">
            <el-button type="primary">Pagination</el-button>
          </router-link> |
          <router-link to="/table">
            <el-button type="primary">Table</el-button>
          </router-link> |
          <router-link to="/emp">
            <el-button type="primary">Emp</el-button>
          </router-link>
          <br><br>
        </el-row>
      </div>
    <router-view />
  </div>
</template>

<script>
export default {

}
</script>

  
<style></style>
  