<template>
    <el-pagination @size-change="sizeChange"
                   @current-change="currentChange"
                   @pre-click="preClick"
                   @next-click="nextClick"
     background layout="sizes, prev, pager, next, jumper, total" :total="90" >
    </el-pagination>
</template>

<script>
export default {
    data() {
        return {
            
        }
    },
    methods:{
        sizeChange:function(size){alert(size)},
        currentChange:function(cur){alert(cur)},
        preClick:function(cur){alert(cur)},
        nextClick:function(cur){alert(cur)},
    }
}
</script>

<style>

</style>