import Layout from '@/views/layout/Layout'

const systemSettingsRouter = {
  path: '/lzx-samples',
  component: Layout,
  redirect: 'noredirect',
  name: 'LZX Samples',
  meta: {
    title: 'LZX Samples',
    icon: 'icon-settings'
  },
  children: [
    {
      path: 'listViewSample',
      component: () => import('@/views/lzx-samples/ListViewSample'),
      name: 'ListViewSample',
      meta: { title: '列表页标准写法', noCache: false, keepAlive: true }
    },
    {
      path: 'formSample',
      component: () => import('@/views/lzx-samples/FormSample'),
      name: 'FormSample',
      meta: { title: '表单标准写法', noCache: true }
    }
  ]
}

export default systemSettingsRouter
