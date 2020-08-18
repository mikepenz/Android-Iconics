/*
 * Copyright 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.typeface.library.devicon

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList

@Suppress("EnumEntryName")
object DevIcon : ITypeface {

    override val fontRes: Int
        get() = R.font.devicon_font_v2_0_0_1

    override val characters: Map<String, Char> by lazy {
        Icon.values().associate { it.name to it.character }
    }

    override val mappingPrefix: String
        get() = "dev"

    override val fontName: String
        get() = "DevIcon"

    override val version: String
        get() = "2.0.0.1"

    override val iconCount: Int
        get() = characters.size

    override val icons: List<String>
        get() = characters.keys.toCollection(LinkedList())

    override val author: String
        get() = "Konpa"

    override val url: String
        get() = "http://devicon.fr/"

    override val description: String
        get() = "Devicon is a set of icons representing programming languages, designing & " +
                "development tools. You can use it as a font or directly copy/paste the svg code " +
                "into your project."

    override val license: String
        get() = "MIT License"

    override val licenseUrl: String
        get() = "https://github.com/konpa/devicon/blob/master/LICENSE"

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(override val character: Char) : IIcon {
        dev_ssh_plain_wordmark('\ue900'),
        dev_ssh_plain('\ue901'),
        dev_sourcetree_plain_wordmark('\ue902'),
        dev_sourcetree_plain('\ue903'),
        dev_phpstorm_plain_wordmark('\ue904'),
        dev_phpstorm_plain('\ue905'),
        dev_jeet_plain_wordmark('\ue906'),
        dev_jeet_plain('\ue907'),
        dev_gitlab_plain_wordmark('\ue908'),
        dev_gitlab_plain('\ue909'),
        dev_github_plain_wordmark('\ue90a'),
        dev_github_plain('\ue90b'),
        dev_d3js_plain('\ue90c'),
        dev_confluence_plain_wordmark('\ue90d'),
        dev_confluence_plain('\ue90e'),
        dev_bitbucket_plain_wordmark('\ue90f'),
        dev_bitbucket_plain('\ue910'),
        dev_safari_line_wordmark('\ue632'),
        dev_safari_line('\ue63a'),
        dev_safari_plain_wordmark('\ue63b'),
        dev_safari_plain('\ue63c'),
        dev_jetbrains_plain_wordmark('\ue63d'),
        dev_django_line_wordmark('\ue63e'),
        dev_django_plain_wordmark('\ue63f'),
        dev_gimp_plain('\ue633'),
        dev_redhat_plain_wordmark('\ue62a'),
        dev_redhat_plain('\ue62b'),
        dev_cplusplus_line_wordmark('\ue634'),
        dev_cplusplus_plain_wordmark('\ue635'),
        dev_csharp_line_wordmark('\ue636'),
        dev_csharp_plain_wordmark('\ue637'),
        dev_c_line_wordmark('\ue638'),
        dev_c_plain_wordmark('\ue639'),
        dev_nodewebkit_line_wordmark('\ue611'),
        dev_nodewebkit_line('\ue612'),
        dev_nodewebkit_plain_wordmark('\ue613'),
        dev_nodewebkit_plain('\ue614'),
        dev_nginx_plain_wordmark('\ue615'),
        dev_erlang_plain_wordmark('\ue616'),
        dev_erlang_plain('\ue617'),
        dev_doctrine_line_wordmark('\ue618'),
        dev_doctrine_line('\ue619'),
        dev_doctrine_plain_wordmark('\ue61a'),
        dev_doctrine_plain('\ue625'),
        dev_apache_line_wordmark('\ue626'),
        dev_apache_line('\ue627'),
        dev_apache_plain_wordmark('\ue628'),
        dev_apache_plain('\ue629'),
        dev_go_line('\ue610'),
        dev_redis_plain_wordmark('\ue606'),
        dev_redis_plain('\ue607'),
        dev_meteor_plain_wordmark('\ue608'),
        dev_meteor_plain('\ue609'),
        dev_heroku_original_wordmark('\ue60a'),
        dev_heroku_original('\ue60b'),
        dev_heroku_plain_wordmark('\ue60c'),
        dev_heroku_plain('\ue60f'),
        dev_go_plain('\ue61b'),
        dev_docker_plain_wordmark('\ue61e'),
        dev_docker_plain('\ue61f'),
        dev_amazonwebservices_plain('\ue603'),
        dev_amazonwebservices_plain_wordmark('\ue604'),
        dev_android_plain_wordmark('\ue60d'),
        dev_android_plain('\ue60e'),
        dev_angularjs_plain_wordmark('\ue61c'),
        dev_angularjs_plain('\ue61d'),
        dev_appcelerator_plain('\ue620'),
        dev_appcelerator_plain_wordmark('\ue621'),
        dev_apple_plain('\ue622'),
        dev_atom_plain_wordmark('\ue623'),
        dev_atom_plain('\ue624'),
        dev_backbonejs_plain_wordmark('\ue62c'),
        dev_backbonejs_plain('\ue62d'),
        dev_bootstrap_plain_wordmark('\ue62e'),
        dev_bootstrap_plain('\ue62f'),
        dev_bower_line_wordmark('\ue630'),
        dev_bower_line('\ue631'),
        dev_bower_plain_wordmark('\ue64e'),
        dev_bower_plain('\ue64f'),
        dev_chrome_plain_wordmark('\ue665'),
        dev_chrome_plain('\ue666'),
        dev_codeigniter_plain_wordmark('\ue667'),
        dev_codeigniter_plain('\ue668'),
        dev_coffeescript_plain_wordmark('\ue669'),
        dev_coffeescript_plain('\ue66a'),
        dev_css3_plain_wordmark('\ue678'),
        dev_css3_plain('\ue679'),
        dev_debian_plain_wordmark('\ue67e'),
        dev_debian_plain('\ue67f'),
        dev_dot_net_plain_wordmark('\ue6d3'),
        dev_dot_net_plain('\ue6d4'),
        dev_drupal_plain_wordmark('\ue6e2'),
        dev_drupal_plain('\ue6e3'),
        dev_firefox_plain_wordmark('\ue75d'),
        dev_firefox_plain('\ue75e'),
        dev_foundation_plain_wordmark('\ue7a2'),
        dev_foundation_plain('\ue7a3'),
        dev_git_plain_wordmark('\ue7a7'),
        dev_git_plain('\ue7a8'),
        dev_grunt_line_wordmark('\ue7a9'),
        dev_grunt_line('\ue7aa'),
        dev_grunt_plain_wordmark('\ue7ea'),
        dev_grunt_plain('\ue7eb'),
        dev_gulp_plain('\ue7ec'),
        dev_html5_plain_wordmark('\ue7f6'),
        dev_html5_plain('\ue7f7'),
        dev_ie10_plain('\ue7f8'),
        dev_illustrator_line('\ue7f9'),
        dev_illustrator_plain('\ue7fa'),
        dev_inkscape_plain_wordmark('\ue834'),
        dev_inkscape_plain('\ue835'),
        dev_java_plain_wordmark('\ue841'),
        dev_java_plain('\ue842'),
        dev_javascript_plain('\ue845'),
        dev_jquery_plain_wordmark('\ue849'),
        dev_jquery_plain('\ue84a'),
        dev_krakenjs_plain_wordmark('\ue84f'),
        dev_krakenjs_plain('\ue850'),
        dev_laravel_plain_wordmark('\ue851'),
        dev_laravel_plain('\ue852'),
        dev_less_plain_wordmark('\ue853'),
        dev_linux_plain('\ueb1c'),
        dev_mongodb_plain_wordmark('\ueb43'),
        dev_mongodb_plain('\ueb44'),
        dev_moodle_plain_wordmark('\ueb5a'),
        dev_moodle_plain('\ueb5b'),
        dev_mysql_plain_wordmark('\ueb60'),
        dev_mysql_plain('\ueb61'),
        dev_nodejs_plain_wordmark('\ueb69'),
        dev_nodejs_plain('\ueb6a'),
        dev_oracle_plain('\ueb6b'),
        dev_photoshop_line('\ueb6c'),
        dev_photoshop_plain('\ueb6d'),
        dev_php_plain('\ueb71'),
        dev_postgresql_plain_wordmark('\ueb7c'),
        dev_postgresql_plain('\ueb7d'),
        dev_python_plain_wordmark('\ueb88'),
        dev_python_plain('\ueb89'),
        dev_rails_plain_wordmark('\ueba2'),
        dev_rails_plain('\ueba3'),
        dev_react_plain_wordmark('\ue600'),
        dev_react_plain('\ue601'),
        dev_ruby_plain_wordmark('\uebc9'),
        dev_ruby_plain('\uebca'),
        dev_sass_plain('\uebcb'),
        dev_symfony_plain_wordmark('\ue602'),
        dev_symfony_plain('\ue605'),
        dev_travis_plain_wordmark('\uebcc'),
        dev_travis_plain('\uebcd'),
        dev_trello_plain_wordmark('\uebce'),
        dev_trello_plain('\uebcf'),
        dev_ubuntu_plain_wordmark('\uebd0'),
        dev_ubuntu_plain('\uebd1'),
        dev_vim_plain('\uebf3'),
        dev_windows8_plain_wordmark('\uebf4'),
        dev_windows8_plain('\uebf5'),
        dev_wordpress_plain_wordmark('\uebfd'),
        dev_wordpress_plain('\uebfe'),
        dev_yii_plain_wordmark('\uec01'),
        dev_yii_plain('\uec02'),
        dev_zend_plain_wordmark('\uec03'),
        dev_zend_plain('\uec04');

        override val typeface: ITypeface by lazy { DevIcon }
    }
}
