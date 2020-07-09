<template>
  <lzx-base-list-view v-loading="loading" :criteria="criteria" :k-active="true" @reset="criteria = { total: 108 }" @goto-page="gotoPage">
    <div slot="criteria" style="padding: 5px;">
      <el-row :gutter="20" style="margin-bottom: -10px;">
        <el-col :span="8">
          <lzx-cell label="条件1">
            <el-input v-model="criteria.condition1" placeholder="请输入查询条件1" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件2">
            <el-input v-model="criteria.condition2" placeholder="请输入查询条件2" size="mini" />
          </lzx-cell>
        </el-col>
        <el-col :span="8">
          <lzx-cell label="条件3">
            <el-input v-model="criteria.condition3" placeholder="请输入查询条件3" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件4">
            <el-slider v-model="criteria.condition4" :max="200" />
          </lzx-cell>
        </el-col>
        <el-col :span="8">
          <lzx-cell label="条件5">
            <el-input v-model="criteria.condition5" placeholder="请输入查询条件5" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件6">
            <el-select v-model="criteria.condition6" size="mini" />
            <!-- 各种类型的下拉选择应该单独制作对应的业务组件 -->
          </lzx-cell>
        </el-col>
      </el-row>
    </div>
    <div slot="fullCriteria" style="padding: 5px;">
      <el-row :gutter="20">
        <el-col :span="8">
          <lzx-cell label="条件1">
            <el-input v-model="criteria.condition1" placeholder="请输入查询条件1" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件2">
            <el-input v-model="criteria.condition2" placeholder="请输入查询条件2" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件22">
            <el-input v-model="criteria.condition2" placeholder="请输入查询条件2" size="mini" />
          </lzx-cell>
        </el-col>
        <el-col :span="8">
          <lzx-cell label="条件3">
            <el-input v-model="criteria.condition3" placeholder="请输入查询条件3" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件4">
            <el-slider v-model="criteria.condition4" :max="200" />
          </lzx-cell>
          <lzx-cell label="条件44">
            <el-slider v-model="criteria.condition4" :max="200" />
          </lzx-cell>
        </el-col>
        <el-col :span="8">
          <lzx-cell label="条件5">
            <el-input v-model="criteria.condition5" placeholder="请输入查询条件5" size="mini" />
          </lzx-cell>
          <lzx-cell label="条件6">
            <el-select v-model="criteria.condition6" size="mini" />
            <!-- 各种类型的下拉选择应该单独制作对应的业务组件 -->
          </lzx-cell>
          <lzx-cell label="条件66">
            <el-select v-model="criteria.condition6" size="mini" />
            <!-- 各种类型的下拉选择应该单独制作对应的业务组件 -->
          </lzx-cell>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-table :data="listData" style="width: 100%">
        <el-table-column prop="id" label="id" width="180" />
        <el-table-column prop="name" label="name" width="180" />
        <el-table-column prop="value" label="value" />
      </el-table>
    </div>
  </lzx-base-list-view>
</template>

<script>
export default {
  data() {
    return {
      loading: false,
      criteria: { condition1: 108 },
      listData: [],
      currentSelectedItem: {}
    }
  },
  methods: {
    gotoPage(pageNum, pageSize, updatePagination) {
      const _this = this
      _this.loading = true
      // _this.criteria.condition1 可以将 criteria, pageNum, pageSize 作为查询条件，此处使用一个 setTimeout 模拟后端接口调用
      // _this.criteria.condition2
      setTimeout(_ => {
        _this.listData = []
        for (let i = 0; i < pageSize; i++) {
          const id = (pageNum - 1) * pageSize + i + 1
          _this.listData[i] = { id: id, name: '条目' + id, value: '内容' + id, section1List: [], section2List: [] }
          for (let j = 0; j < 2; j++) {
            _this.listData[i].section1List.push({ id: j })
            _this.listData[i].section2List.push({ id: j })
          }
        }
        // 查询到结果后，必须调用 updatePagination 方法，lzx-base-list-view 才可以将结果显示出来
        updatePagination({ pageNum: pageNum, pageSize: pageSize, total: this.criteria.condition1 })
        this.loading = false
      }, 800)
    }
  }
}
</script>
