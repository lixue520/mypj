<template>
    <div>
        <!-- <el-button type="primary" icon="el-icon-edit" @click="add">添加</el-button> -->
        <!-- Form -->
        <!-- 轮播图显示 -->
        <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in tableData" :key="item.id">
                <div class="medium">
                    <div>ID:{{ item.id }}</div>
                    <div>排序:{{ item.sort }}</div>
                    <el-image :src=item.img>
                        <div slot="placeholder" class="image-slot">
                            加载中<span class="dot">...</span>
                        </div>
                    </el-image>
                </div>
            </el-carousel-item>
        </el-carousel>
        <el-button type="primary" @click="getall()">显示数据</el-button>

        <el-button type="primary" @click="dialogFormVisible = true">添加</el-button>

        <el-dialog title="新增数据" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="类型" :label-width="formLabelWidth">
                    <el-input v-model="form.type" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="链接地址" :label-width="formLabelWidth">
                    <el-input v-model="form.link" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片地址" :label-width="formLabelWidth">
                    <el-input v-model="form.img" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="备注" :label-width="formLabelWidth">
                    <el-input v-model="form.remark" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <!-- <el-button @click="dialogFormVisible = false">取 消</el-button> -->
                <el-button type="primary" @click="additem(form)">保存</el-button>
            </div>
        </el-dialog>



        <el-table :data="tableData" style="width: 100%">

            <el-table-column label="ID" width="100">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>

            <el-table-column label="类型" width="100">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.type }}</span>
                </template>
            </el-table-column>

            <el-table-column label="排序" width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.sort }}</span>
                </template>
            </el-table-column>

            <el-table-column label="链接" width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.link }}</span>
                </template>
            </el-table-column>

            <el-table-column label="图片" width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.img }}</span>
                </template>
            </el-table-column>

            <el-table-column label="备注" width="180">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.remark }}</span>
                </template>
            </el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" @click="MoveUp(scope.row.id, scope.row.sort)">上移</el-button>
                    <el-button size="mini" @click="MoveDown(scope.row.id, scope.row.sort)">下移</el-button>
                    <el-button size="mini" @click="Delete(scope.row.id)">删除</el-button>
                    <el-button size="mini" @click="dialogFormVisible1 = true,test=scope.row.id"  >修改</el-button>

                    <el-dialog title="修改数据" :visible.sync="dialogFormVisible1">
                        <el-form :model="form1">
                            <div>ID:{{ test }}</div>
                            <el-form-item label="类型" :label-width="formLabelWidth">
                                <el-input v-model="form1.type" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="链接地址" :label-width="formLabelWidth">
                                <el-input v-model="form1.link" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="排序" :label-width="formLabelWidth">
                                <el-input v-model="form1.sort" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="图片地址" :label-width="formLabelWidth">
                                <el-input v-model="form1.img" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="备注" :label-width="formLabelWidth">
                                <el-input v-model="form1.remark" autocomplete="off"></el-input>
                            </el-form-item>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <!-- <el-button @click="dialogFormVisible = false">取 消</el-button> -->
                            <el-button type="primary" @click="Modify(test)">保存</el-button>
                        </div>
                    </el-dialog>


                </template>
            </el-table-column>

        </el-table>
    </div>

</template>

<script>
export default {
    name: 'CarouselEditing',
    data() {
        return {
            gridData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }],
            dialogTableVisible: false,
            dialogFormVisible: false,
            dialogTableVisible1: false,
            dialogFormVisible1: false,
            test:"",
            form: {
                type: '',
                link: '',
                img: '',
                remark: ''
            },
            form1: {
                id: '',
                sort: '',
                type: '',
                link: '',
                img: '',
                remark: ''
            },
            senditem: { //用于上一移动的数据
                id: '',
                sort: '',
                type: '',
                link: '',
                img: '',
                remark: ''
            }
            ,
            formLabelWidth: '120px',
            tableData: []
        }
    }, methods: {
        /**
         * 
         * Move up move down modify delete
         */
        MoveUp(id, sort) {
            if (sort > 1) {
                this.senditem.id = id;
                this.senditem.sort = parseInt(sort) - 1;
                console.log("上移");
                this.$axios.post('banner/move'
                    , this.senditem).then((res) => {
                        console.log(res)
                        this.$axios.get('banner/list').then(res => {
                            this.tableData = res.data.data
                            console.log(res.data.data)
                        })
                    })
            }

        },
        MoveDown(id, sort) {
            if (sort < 10) {
                this.senditem.id = id;
                this.senditem.sort = parseInt(sort) + 1;
                console.log("下移");
                this.$axios.post('banner/move'
                    , this.senditem).then((res) => {
                        console.log(res)
                        this.$axios.get('banner/list').then(res => {
                            this.tableData = res.data.data
                            console.log(res.data.data)
                        })
                    })
            }
        },
        Modify(id) {
            console.log("修改");
            console.log(id)
            this.form1.id = id;
            console.log(this.form1)
            this.$axios.post('banner/Edit'
                , this.form1).then((res) => {
                    console.log(res)
                    this.$axios.get('banner/list').then(res => {
                        this.tableData = res.data.data
                        console.log(res.data.data)
                    })
                })
        },
        Delete(id) {
            this.senditem.id = id;
            console.log("上移");
            this.$axios.post('banner/Dell'
                , this.senditem).then((res) => {
                    console.log(res)
                    this.$axios.get('banner/list').then(res => {
                        this.tableData = res.data.data
                        console.log(res.data.data)
                    })
                })

        },
        getall() {
            console.log("获取所有数据");
            this.$axios.get('banner/list').then(res => {
                this.tableData = res.data.data
                console.log(res.data.data)
            })
        }, additem(form) {
            console.log(form)
            this.$axios.post('banner/add'
                , form).then((res) => {
                    console.log(res)
                    this.$axios.get('banner/list').then(res => {
                        this.tableData = res.data.data
                        console.log(res.data.data)
                    })
                })
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}

.el-image {
    width: 150px;
    height: 150px;
}
</style>
